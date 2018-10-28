import Test.QuickCheck

mycont :: [Int] -> Bool 
mycont xs = not ((elem 7 xs) && (elem 30 xs))

prop_positivePlusOne :: Property
prop_positivePlusOne =
    forAll 
        (listOf (choose (1, 10000))) 
        mycont
