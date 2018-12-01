import Test.QuickCheck

buggySum :: [Int] -> Int
buggySum xs = 
    if (elem 7 xs) && (elem 30 xs)
        then (sum xs) - 1
        else sum xs

prop_sum :: [Int] -> Bool
prop_sum xs = 
    sum xs == buggySum xs