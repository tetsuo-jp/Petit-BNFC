package petit;
import petit.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ProgramVisitor<R,A> implements Program.Visitor<R,A>
  {
    public R visit(petit.Absyn.PDefs p, A arg)
    {
      /* Code For PDefs Goes Here */

      for (Stm x : p.liststm_) {
      }

      return null;
    }

  }
  public class StmVisitor<R,A> implements Stm.Visitor<R,A>
  {
    public R visit(petit.Absyn.SAss p, A arg)
    {
      /* Code For SAss Goes Here */

      //p.ident_;
      p.exp_.accept(new ExpVisitor<R,A>(), arg);

      return null;
    }
    public R visit(petit.Absyn.SFor p, A arg)
    {
      /* Code For SFor Goes Here */

      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      p.stm_.accept(new StmVisitor<R,A>(), arg);

      return null;
    }

  }
  public class ExpVisitor<R,A> implements Exp.Visitor<R,A>
  {
    public R visit(petit.Absyn.EZer p, A arg)
    {
      /* Code For EZer Goes Here */


      return null;
    }
    public R visit(petit.Absyn.ESuc p, A arg)
    {
      /* Code For ESuc Goes Here */

      p.exp_.accept(new ExpVisitor<R,A>(), arg);

      return null;
    }
    public R visit(petit.Absyn.EVar p, A arg)
    {
      /* Code For EVar Goes Here */

      //p.ident_;

      return null;
    }

  }
}