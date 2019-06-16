/*
 * @lc app=leetcode.cn id=726 lang=csharp
 *
 * [726] 原子的数量
 * a-z：97-122
 * A-Z：65-90
 * 0-9：48-57
 */
using System;
using System.Collections;
using System.Collections.Generic;

public class Solution {
    public string CountOfAtoms (string formula) {
        Stack<Dictionary<string, int>> skRes = new Stack<Dictionary<string, int>> ();
        skRes.Push (new Dictionary<string, int> ());
        int i = 0;
        while (i < formula.Length) {
            if (formula[i].Equals ('(')) {
                skRes.Push (new Dictionary<string, int> ());
                i++;
            } else if (formula[i].Equals (')')) {
                int start = ++i;
                while (i < formula.Length && formula[i] >= 48 && formula[i] <= 57) i++;
                int multiplicity = i > start? Convert.ToInt32 (formula.Substring (start, i - start)) : 1;
                if (multiplicity != 1) {
                    Dictionary<string, int> dicTemp = skRes.Pop ();
                    Dictionary<string, int> dicTemp2 = skRes.Peek ();
                    foreach (var name in dicTemp.Keys) {
                        if (dicTemp2.ContainsKey (name)) {
                            dicTemp2[name] += dicTemp[name] * multiplicity;
                        } else {
                            dicTemp2.Add (name, dicTemp[name] * multiplicity);
                        }
                    }
                }
            } else {
                int start = i++;
                while (i < formula.Length && formula[i] >= 97 && formula[i] <= 122) i++;
                string name = formula.Substring (start, i - start);

                start = i;
                while (i < formula.Length && formula[i] >= 48 && formula[i] <= 57) i++;
                int multiplicity = i > start? Convert.ToInt32 (formula.Substring (start, i - start)) : 1;

                Dictionary<string, int> dicTemp = skRes.Peek ();
                if (dicTemp.ContainsKey (name)) {
                    dicTemp[name] = dicTemp[name] + multiplicity;
                } else {
                    dicTemp.Add (name, multiplicity);
                }
            }
        }

        string strRes = "";
        Dictionary<string, int> dicRes = skRes.Peek ();
        List<string> lst = new List<string> ();
        foreach (var name in dicRes.Keys) {
            lst.Add (name);
        }
        lst.Sort ();
        for (int k = 0; k < lst.Count; k++) {
            if (dicRes[lst[k]] > 1)
                strRes += (lst[k] + dicRes[lst[k]]);
            else
                strRes += (lst[k] + "");
        }

        return strRes;
    }
}