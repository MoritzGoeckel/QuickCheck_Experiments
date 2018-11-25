import Test.QuickCheck

buggySum :: [Int] -> Int
buggySum xs = 
    if not ((elem 7 xs) && (elem 30 xs))
        then sum xs
        else (sum xs) - 1

prop_sum :: [Int] -> Bool
prop_sum xs = 
    sum xs == buggySum xs