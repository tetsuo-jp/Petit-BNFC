package petit;
import petit.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* Program */
    public R visit(petit.Absyn.PDefs p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(petit.Absyn.Program p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Stm */
    public R visit(petit.Absyn.SAss p, A arg) { return visitDefault(p, arg); }
    public R visit(petit.Absyn.SFor p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(petit.Absyn.Stm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Exp */
    public R visit(petit.Absyn.EZer p, A arg) { return visitDefault(p, arg); }
    public R visit(petit.Absyn.ESuc p, A arg) { return visitDefault(p, arg); }
    public R visit(petit.Absyn.EVar p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(petit.Absyn.Exp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
