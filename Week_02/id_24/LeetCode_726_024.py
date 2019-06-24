import re
from collections import deque

def stuffSubStack(stack, sub_stack):
    char = stack.pop() 
    while char != '(':
        sub_stack.append(char)
        char = stack.pop()

def emptySubStack(stack, sub_stack):
    while sub_stack:
        stack.append(sub_stack.pop())

def enlargeSubStack(stack, sub_stack, multiple):
    prev = '' 
    while sub_stack:
        char = sub_stack.pop()
        if re.match( r'\d', char): stack.append(str(int(char) * int(multiple))) 
        else:
            if re.match( r'[A-Z]', char) and re.match( r'[a-zA-Z]', prev): stack.append(multiple)
            stack.append(char)
            if len(sub_stack) == 0 and re.match( r'[a-zA-Z]', char): stack.append(multiple) 
        prev = char

def dealSubAndNum(stack, sub_stack, num_str):
    if sub_stack and num_str: enlargeSubStack(stack, sub_stack, num_str)
    elif sub_stack and not num_str: emptySubStack(stack, sub_stack) 
    elif not sub_stack and num_str: stack.append(num_str)

def getAtomsNumHash(stack):
    sub = ''
    sub_hash = {}
    while stack:
        char = stack.popleft()
        if re.match( r'\d', char):
            sub_hash[sub] = int(char) + (sub_hash[sub] if sub in sub_hash else 0)
            sub = ''
        elif re.match( r'[A-Z]', char): 
            if (sub): sub_hash[sub] = 1
            sub = char
        elif re.match( r'[a-z]', char): 
            sub += char
    if sub: sub_hash[sub] = 1
    return sub_hash

def getAtomsNumStr(sub_hash):
    hash_str = ''
    sorted_hash = sorted(sub_hash)
    for i in range(len(sorted_hash)):
        hash_str += sorted_hash[i]
        hash_str += str(sub_hash[sorted_hash[i]]) if sub_hash[sorted_hash[i]] != 1 else ''
    return hash_str

def countOfAtoms(formula):
        stack = deque()
        sub_stack = []
        num_str = ''
        for i in range(len(formula)):
            if re.match( r'\(|\)', formula[i]): dealSubAndNum(stack, sub_stack, num_str)
            if re.match( r'\)', formula[i]): stuffSubStack(stack, sub_stack)
            elif re.match( r'[A-Z]', formula[i]) and num_str:
                if sub_stack: enlargeSubStack(stack, sub_stack, num_str)
                else: stack.append(num_str)
            if not re.match( r'\)|\d', formula[i]): stack.append(formula[i])
            num_str = (num_str + formula[i]) if re.match( r'\d', formula[i]) else ''

        dealSubAndNum(stack, sub_stack, num_str)
        
        return getAtomsNumStr(getAtomsNumHash(stack))

            
print(countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"))