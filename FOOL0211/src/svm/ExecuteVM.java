package svm;

/**
 * La classe contiene il codice di esecuzione.
 * Contiene il ciclo fetch-execute
 */
public class ExecuteVM {

    public static final int CODESIZE = 10000;
    public static final int MEMSIZE = 10000;

    private final int[] code;
    private final int[] memory = new int[MEMSIZE]; // Ci mettiamo lo stack. Lo stack cresce verso il basso.

    // Extraction Pointer. Contiene l'indirizzo dell'istruzione da eseguire.
    private int ip = 0;
    // Stack Pointer. Punta al top dello stack
    private int sp = MEMSIZE;
    private int tm; // memoria per Temporary Storage
    private int hp = 0; // memoria per Heap Pointer
    private int fp = MEMSIZE; // memoria per Frame Pointer
    private int ra; // memoria per Return Address

    public ExecuteVM(int[] code) {
        this.code = code;
    }

    public void cpu() {
        while (true) {
            int bytecode = code[ip++]; // fetch
            int v1, v2;
            int address;
            switch (bytecode) {
                case SVMParser.PUSH:
                    push(code[ip++]);
                    break;
                case SVMParser.POP:
                    pop();
                    break;
                case SVMParser.ADD:
                    v1 = pop();
                    v2 = pop();
                    push(v2 + v1);
                    break;
                case SVMParser.SUB:
                    v1 = pop();
                    v2 = pop();
                    push(v2 - v1);
                    break;
                case SVMParser.MULT:
                    v1 = pop();
                    v2 = pop();
                    push(v2 * v1);
                    break;
                case SVMParser.DIV:
                    v1 = pop();
                    v2 = pop();
                    push(v2 / v1);
                    break;
                case SVMParser.STOREW:
                    address = pop();
                    memory[address] = pop();
                    break;
                case SVMParser.LOADW:
                    address = pop();
                    push(memory[address]);
                    break;
                case SVMParser.BRANCH:
                    address = code[ip]; // prendo il code di IP e lo setto ad address
                    ip = address;
                    break;
                case SVMParser.BRANCHEQ:
                    address = code[ip++];
                    v1 = pop();
                    v2 = pop();
                    if (v2 == v1)
                        ip = address;
                    break;
                case SVMParser.BRANCHLESSEQ:
                    address = code[ip++];
                    v1 = pop();
                    v2 = pop();
                    if (v2 <= v1)
                        ip = address;
                    break;
                case SVMParser.JS:
                    address = pop();
                    ra = ip;
                    sp = address;
                    break;
                case SVMParser.LOADRA:
                    push(ra);
                    break;
                case SVMParser.STORERA:
                    ra = pop();
                    break;
                case SVMParser.LOADTM:
                    push(tm);
                    break;
                case SVMParser.STORETM:
                    tm = pop();
                    break;
                case SVMParser.LOADFP:
                    push(fp);
                    break;
                case SVMParser.STOREFP:
                    fp = pop();
                    break;
                case SVMParser.COPYFP:
                    fp = sp;
                    break;
                case SVMParser.LOADHP:
                    push(hp);
                    break;
                case SVMParser.STOREHP:
                    hp = pop();
                    break;
                case SVMParser.PRINT:
                    System.out.println(sp < MEMSIZE ? " - valore in cima allo stack: " + memory[sp] : "Stack vuoto!");
                    break;
                case SVMParser.HALT:
                    return;
                case SVMParser.LABEL:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + bytecode);
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