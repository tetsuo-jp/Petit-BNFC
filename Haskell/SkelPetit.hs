module SkelPetit where

-- Haskell module generated by the BNF converter

import AbsPetit
import ErrM
type Result = Err String

failure :: Show a => a -> Result
failure x = Bad $ "Undefined case: " ++ show x

transIdent :: Ident -> Result
transIdent x = case x of
  Ident string -> failure x
transProgram :: Program -> Result
transProgram x = case x of
  PDefs stms -> failure x
transStm :: Stm -> Result
transStm x = case x of
  SAss ident exp -> failure x
  SFor exp stm -> failure x
transExp :: Exp -> Result
transExp x = case x of
  EZer -> failure x
  ESuc exp -> failure x
  EVar ident -> failure x

