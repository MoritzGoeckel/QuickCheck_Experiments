import Test.QuickCheck

prop_sumRev :: [Int] -> Property 
prop_sumRev xs =       
    classify (null xs || xs == []) "Array empty" $
    sum xs == sum (reverse xs) 
