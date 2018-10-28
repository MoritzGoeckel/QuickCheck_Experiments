import Test.QuickCheck

prop_positivePlusOne :: Property
prop_positivePlusOne =
    forAll 
        (choose (1, 10000)) 
        ((\x -> x + 1 > 0) :: Integer -> Bool) 
