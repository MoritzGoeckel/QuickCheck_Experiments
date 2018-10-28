import Test.QuickCheck

prop_sumRev :: [Int] -> Property 
prop_sumRev xs =       
    collect (length xs) $
    sum xs == sum (reverse xs) 
