package petit;
import petit.Absyn.*;

public class Interpreter extends AbstractVisitor<State,State> {
    public static Integer interpret(Program p) {
	State st = p.accept(new ExecProgram(), new State());
	return st.lookupVar("X");
    }

   private static Integer eval(Exp e, State st) {
	return e.accept(new EvalExp(), st);
    }

   private static State exec(Stm s, State st) {
	return s.accept(new ExecStm(), st);
    }

    private static class ExecProgram implements Program.Visitor<State,State> {
	public State visit(petit.Absyn.PDefs p, State st) {
	    for (Stm s : p.liststm_) {
		st = exec(s,st);
	    }
	    return st;
	}
    }

    private static class ExecStm implements Stm.Visitor<State,State> {
	public State visit(petit.Absyn.SAss p, State st) {
	    Integer v = eval(p.exp_, st);
	    st.updateVar(p.ident_, v);
	    return st;
	}
	public State visit(petit.Absyn.SFor p, State st) {
	    Integer n = eval(p.exp_, st);
	    for (int i = 0; i < n; i++) {
		p.stm_.accept(this, st);
	    }
	    return st;
	}
    }

    private static class EvalExp implements Exp.Visitor<Integer,State> {
	public Integer visit(petit.Absyn.EZer p, State st) {
	    return 0;
	}
	public Integer visit(petit.Absyn.ESuc p, State st) {
	    Integer a = eval(p.exp_, st);
	    return a + 1;
	}
	public Integer visit(petit.Absyn.EVar p, State st)
	{
	    return st.lookupVar(p.ident_);
	}
    }
}
