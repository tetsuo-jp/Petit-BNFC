package petit;
import petit.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  petit.Absyn.Program.Visitor<petit.Absyn.Program,A>,
  petit.Absyn.Stm.Visitor<petit.Absyn.Stm,A>,
  petit.Absyn.Exp.Visitor<petit.Absyn.Exp,A>
{
/* Program */
    public Program visit(petit.Absyn.PDefs p, A arg)
    {
      ListStm liststm_ = new ListStm();
      for (Stm x : p.liststm_) {
        liststm_.add(x.accept(this,arg));
      }

      return new petit.Absyn.PDefs(liststm_);
    }

/* Stm */
    public Stm visit(petit.Absyn.SAss p, A arg)
    {
      String ident_ = p.ident_;
      Exp exp_ = p.exp_.accept(this, arg);

      return new petit.Absyn.SAss(ident_, exp_);
    }
    public Stm visit(petit.Absyn.SFor p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);
      Stm stm_ = p.stm_.accept(this, arg);

      return new petit.Absyn.SFor(exp_, stm_);
    }

/* Exp */
    public Exp visit(petit.Absyn.EZer p, A arg)
    {

      return new petit.Absyn.EZer();
    }
    public Exp visit(petit.Absyn.ESuc p, A arg)
    {
      Exp exp_ = p.exp_.accept(this, arg);

      return new petit.Absyn.ESuc(exp_);
    }
    public Exp visit(petit.Absyn.EVar p, A arg)
    {
      String ident_ = p.ident_;

      return new petit.Absyn.EVar(ident_);
    }

}