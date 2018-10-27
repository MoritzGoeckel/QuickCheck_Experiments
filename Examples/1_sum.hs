import Test.QuickCheck
prop_sumRev :: [Int] -> Bool
prop_sumRev xs = sum xs == sum (reverse xs)
prop_sumRevWrong xs = sum xs == sum (reverse (xs ++ [1]))

