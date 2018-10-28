import Test.QuickCheck

mostlyPositive :: Gen Int
mostlyPositive =
  frequency
    [ 
        (10, choose (1, 10)),
        (1, choose (-10, -1)),
        (1, return 0)
    ]

-- generate vectorOf 12 mostlyPositive 
