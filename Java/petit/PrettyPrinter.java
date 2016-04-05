package petit;
import petit.Absyn.*;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + 2;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       _n_ = _n_ - 2;
       backup();
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(petit.Absyn.Program foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(petit.Absyn.Program foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(petit.Absyn.ListStm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(petit.Absyn.ListStm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(petit.Absyn.Stm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(petit.Absyn.Stm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(petit.Absyn.Exp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(petit.Absyn.Exp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(petit.Absyn.Program foo, int _i_)
  {
    if (foo instanceof petit.Absyn.PDefs)
    {
       petit.Absyn.PDefs _pdefs = (petit.Absyn.PDefs) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_pdefs.liststm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(petit.Absyn.ListStm foo, int _i_)
  {
     for (java.util.Iterator<Stm> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(";");
       } else {
         render("");
       }
     }
  }

  private static void pp(petit.Absyn.Stm foo, int _i_)
  {
    if (foo instanceof petit.Absyn.SAss)
    {
       petit.Absyn.SAss _sass = (petit.Absyn.SAss) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sass.ident_, 0);
       render(":=");
       pp(_sass.exp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof petit.Absyn.SFor)
    {
       petit.Absyn.SFor _sfor = (petit.Absyn.SFor) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("for");
       pp(_sfor.exp_, 0);
       render("times");
       render("do");
       pp(_sfor.stm_, 0);
       render("end");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(petit.Absyn.Exp foo, int _i_)
  {
    if (foo instanceof petit.Absyn.EZer)
    {
       petit.Absyn.EZer _ezer = (petit.Absyn.EZer) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("0");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof petit.Absyn.ESuc)
    {
       petit.Absyn.ESuc _esuc = (petit.Absyn.ESuc) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("suc");
       pp(_esuc.exp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof petit.Absyn.EVar)
    {
       petit.Absyn.EVar _evar = (petit.Absyn.EVar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_evar.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(petit.Absyn.Program foo)
  {
    if (foo instanceof petit.Absyn.PDefs)
    {
       petit.Absyn.PDefs _pdefs = (petit.Absyn.PDefs) foo;
       render("(");
       render("PDefs");
       render("[");
       sh(_pdefs.liststm_);
       render("]");
       render(")");
    }
  }

  private static void sh(petit.Absyn.ListStm foo)
  {
     for (java.util.Iterator<Stm> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(petit.Absyn.Stm foo)
  {
    if (foo instanceof petit.Absyn.SAss)
    {
       petit.Absyn.SAss _sass = (petit.Absyn.SAss) foo;
       render("(");
       render("SAss");
       sh(_sass.ident_);
       sh(_sass.exp_);
       render(")");
    }
    if (foo instanceof petit.Absyn.SFor)
    {
       petit.Absyn.SFor _sfor = (petit.Absyn.SFor) foo;
       render("(");
       render("SFor");
       sh(_sfor.exp_);
       sh(_sfor.stm_);
       render(")");
    }
  }

  private static void sh(petit.Absyn.Exp foo)
  {
    if (foo instanceof petit.Absyn.EZer)
    {
       petit.Absyn.EZer _ezer = (petit.Absyn.EZer) foo;
       render("EZer");
    }
    if (foo instanceof petit.Absyn.ESuc)
    {
       petit.Absyn.ESuc _esuc = (petit.Absyn.ESuc) foo;
       render("(");
       render("ESuc");
       sh(_esuc.exp_);
       render(")");
    }
    if (foo instanceof petit.Absyn.EVar)
    {
       petit.Absyn.EVar _evar = (petit.Absyn.EVar) foo;
       render("(");
       render("EVar");
       sh(_evar.ident_);
       render(")");
    }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(d); buf_.append(" "); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(d.toString()); }
  private static void sh(Character c) { render(c.toString()); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(" ");
      n--;
    }
  }
  private static void backup()
  {
     if (buf_.charAt(buf_.length() - 1) == ' ') {
      buf_.setLength(buf_.length() - 1);
    }
  }
  private static void trim()
  {
     while (buf_.length() > 0 && buf_.charAt(0) == ' ')
        buf_.deleteCharAt(0); 
    while (buf_.length() > 0 && buf_.charAt(buf_.length()-1) == ' ')
        buf_.deleteCharAt(buf_.length()-1);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

