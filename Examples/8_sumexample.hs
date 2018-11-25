import Test.QuickCheck

prop_sum :: Property
prop_sum = 
    forAll
        (vectorOf 2 (choose (0, 10)))
        ((\xs -> sum xs == xs!!0 + xs!!1) :: [Integer] -> Bool)