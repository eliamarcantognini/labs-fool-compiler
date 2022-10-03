push 1
push 5
add
push 1
push 5
add
push 1
lfp
push -2
add
lw
push 1
beq label2
lfp
push -1
add
lw
push 2
add
b label3
label2:
lfp
push -1
add
lw
push 1
add
label3:
print
halt