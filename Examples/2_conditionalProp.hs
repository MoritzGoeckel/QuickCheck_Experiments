import Test.QuickCheck
prop_positivePlusOne :: Int -> Property
prop_positivePlusOne x = 
    x > 0 ==> x + 1 > 0