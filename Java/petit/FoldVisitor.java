package petit;

import petit.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* Program */
    public R visit(petit.Absyn.PDefs p, A arg) {
      R r = leaf(arg);
      for (Stm x : p.liststm_) {
        r = combine(x.accept(this,arg), r, arg);
      }
      return r;
    }

/* Stm */
    public R visit(petit.Absyn.SAss p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(petit.Absyn.SFor p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      r = combine(p.stm_.accept(this, arg), r, arg);
      return r;
    }

/* Exp */
    public R visit(petit.Absyn.EZer p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(petit.Absyn.ESuc p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(petit.Absyn.EVar p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
