package svm;

public class ExecuteVM {

    public static final int CODESIZE = 10000;
    public static final int MEMSIZE = 10000;

    private int[] code;
    private int[] memory = new int[MEMSIZE];

    private int ip = 0;
    private int sp = MEMSIZE; //punta al top dello stack

    public ExecuteVM(int[] code) {
        this.code = code;
    }

    public void cpu() {
        while ( true ) {
            int bytecode = code[ip++]; // fetch
            int v1,v2;
            int address;
            switch ( bytecode ) {
//          case SVMParser.PUSH:

//             break;

//          case SVMParser.ADD:
//             v1=pop();
//             v2=pop();

//             break;
            }
        }
    }

    private int pop() {
        return memory[sp++];
    }

    private void push(int v) {
        memory[--sp] = v;
    }

}