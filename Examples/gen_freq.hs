import Test.QuickCheck
loadedDice :: Gen Int
loadedDice =
  frequency
    [ 
        (1, return 1),
        (1, return 2),
        (1, return 3),
        (1, return 4),
        (1, return 5),
        (7, return 6)
    ]

-- generate vectorOf 12 loadedDice
