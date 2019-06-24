import "strconv"
import "strings"
import "sort"

func countOfAtoms(formula string) string {
	s := []byte(formula)
	resultmap, _ := helper(s, 0)
	resultstrs := make([]string, len(resultmap))
	for k, v := range resultmap {
		vstr := strconv.Itoa(v)
		if vstr == "1" {
			vstr = ""
		}
		resultstrs = append(resultstrs, k+vstr)
	}
	sort.Strings(resultstrs)
	return strings.Join(resultstrs, "")

}

func helper(s []byte, start int) (map[string]int, int) {
	elmentmap := make(map[string]int)
	i := start
	curel := ""
	for i < len(s) {
		if curel != "" && (s[i] < '0' || s[i] > '9') {
			elmentmap[curel] += 1
			curel = ""
		}
		if s[i] >= 'A' && s[i] <= 'Z' {
			elbytes := make([]byte, 0)
			elbytes = append(elbytes, s[i])
			for i+1 < len(s) && s[i+1] >= 'a' && s[i+1] <= 'z' {
				i++
				elbytes = append(elbytes, s[i])
			}
			curel = string(elbytes)
		}
		if s[i] >= '0' && s[i] <= '9' {
			nbyte := make([]byte, 0)
			nbyte = append(nbyte, s[i])
			for i+1 < len(s) && s[i+1] >= '0' && s[i+1] <= '9' {
				i++
				nbyte = append(nbyte, s[i])
			}
			numbyte, _ := strconv.Atoi(string(nbyte))
			elmentmap[curel] += numbyte
			curel = ""
		} else if s[i] == '(' {
			subelmap, pos := helper(s, i+1)
			for k, v := range subelmap {
				elmentmap[k] += v
			}
			i = pos
		} else if s[i] == ')' {
			nbyte := make([]byte, 0)
			for i+1 < len(s) && s[i+1] >= '0' && s[i+1] <= '9' {
				i++
				nbyte = append(nbyte, s[i])
			}
			if len(nbyte) > 0 {
				numbyte, _ := strconv.Atoi(string(nbyte))
				for k, v := range elmentmap {
					elmentmap[k] = v * numbyte
				}
			}
			return elmentmap, i
		}
		i++
	}
	if curel != "" {
		elmentmap[curel] += 1
		curel = ""
	}
	return elmentmap, i
}