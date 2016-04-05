-- This Happy file was machine-generated by the BNF converter
{
{-# OPTIONS_GHC -fno-warn-incomplete-patterns -fno-warn-overlapping-patterns #-}
module ParPetit where
import AbsPetit
import LexPetit
import ErrM

}

%name pProgram Program
%name pListStm ListStm
%name pStm Stm
%name pExp Exp
-- no lexer declaration
%monad { Err } { thenM } { returnM }
%tokentype {Token}
%token
  '0' { PT _ (TS _ 1) }
  ':=' { PT _ (TS _ 2) }
  ';' { PT _ (TS _ 3) }
  'do' { PT _ (TS _ 4) }
  'end' { PT _ (TS _ 5) }
  'for' { PT _ (TS _ 6) }
  'suc' { PT _ (TS _ 7) }
  'times' { PT _ (TS _ 8) }

L_ident  { PT _ (TV $$) }


%%

Ident   :: { Ident }   : L_ident  { Ident $1 }

Program :: { Program }
Program : ListStm { AbsPetit.PDefs $1 }
ListStm :: { [Stm] }
ListStm : {- empty -} { [] }
        | Stm { (:[]) $1 }
        | Stm ';' ListStm { (:) $1 $3 }
Stm :: { Stm }
Stm : Ident ':=' Exp { AbsPetit.SAss $1 $3 }
    | 'for' Exp 'times' 'do' Stm 'end' { AbsPetit.SFor $2 $5 }
Exp :: { Exp }
Exp : '0' { AbsPetit.EZer }
    | 'suc' Exp { AbsPetit.ESuc $2 }
    | Ident { AbsPetit.EVar $1 }
{

returnM :: a -> Err a
returnM = return

thenM :: Err a -> (a -> Err b) -> Err b
thenM = (>>=)

happyError :: [Token] -> Err a
happyError ts =
  Bad $ "syntax error at " ++ tokenPos ts ++ 
  case ts of
    [] -> []
    [Err _] -> " due to lexer error"
    t:_ -> " before `" ++ id(prToken t) ++ "'"

myLexer = tokens
}

