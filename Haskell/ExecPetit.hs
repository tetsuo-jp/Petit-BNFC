module ExecPetit(execute) where
import AbsPetit

type State = String -> Int

execute :: Program -> Int
execute (PDefs ss) =
    let st = foldl (flip exec) undefined ss
    in st "X"

exec :: Stm -> State -> State
exec (SAss (Ident x) e) st = update (x,eval e st) st
exec (SFor e s)         st = myiterate (exec s, eval e st) st

eval :: Exp -> State  -> Int
eval EZer             st = 0
eval (ESuc e)         st = eval e st + 1
eval (EVar (Ident x)) st = st x

-- |Update of states
update (x,y) st z | x == z    = y
                  | otherwise = st z

-- |Application of theta n times
myiterate (trans,n) = foldl1 (.) $ replicate n trans
