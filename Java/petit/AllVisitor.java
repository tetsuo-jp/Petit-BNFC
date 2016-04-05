package petit;

import petit.Absyn.*;

/** BNFC-Generated All Visitor */
public interface AllVisitor<R,A> extends
  petit.Absyn.Program.Visitor<R,A>,
  petit.Absyn.Stm.Visitor<R,A>,
  petit.Absyn.Exp.Visitor<R,A>
{}
