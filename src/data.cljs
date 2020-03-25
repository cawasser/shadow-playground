(ns data)


(def line-data [{:name "trace 1"
                 :data [5, 25, 50, 120, 150, 200, 426, 660, 869, 1060,
                        1605, 2471, 3322, 4238, 5221, 6129, 7089, 8339, 9399, 10538,
                        11643, 13092, 14478, 15915, 17385, 19055, 21205, 23044, 25393, 27935,
                        30062, 32049, 33952, 35804, 37431, 39197, 45000, 43000, 41000, 39000,
                        37000, 35000, 33000, 31000, 29000, 27000, 25000, 24000, 23000, 22000,
                        21000, 20000, 19000, 18000, 18000, 17000, 16000, 15537, 14162, 12787,
                        12600, 11400, 5500, 4512, 4502, 4502, 4500, 4500]}
                {:name "trace 2"
                 :data [6, 11, 32, 110, 235,
                        369, 640, 1005, 1436, 2063, 3057, 4618, 6444, 9822, 15468,
                        20434, 24126, 27387, 29459, 31056, 31982, 32040, 31233, 29224, 27342,
                        26662, 26956, 27912, 28999, 28965, 27826, 25579, 25722, 24826, 24605,
                        24304, 23464, 23708, 24099, 24357, 24237, 24401, 24344, 23586, 22380,
                        21004, 17287, 14747, 13076, 12555, 12144, 11009, 10950, 10871, 10824,
                        10577, 10527, 10475, 10421, 10358, 10295, 10104, 9914, 9620, 9326,
                        5113, 5113, 4954, 4804, 4761, 4717, 4368, 4018]}])


(def sankey-data [{:keys ["from" "to" "weight"]
                   :data [["Oil" "Transportation" 94]
                          ["Natural Gas" "Transportation" 3]
                          ["Coal" "Transportation" 0]
                          ["Renewable" "Transportation" 0]
                          ["Nuclear" "Transportation" 3]
                          ["Oil" "Industrial" 41]
                          ["Natural Gas" "Industrial" 40]
                          ["Coal" "Industrial" 7]
                          ["Renewable" "Industrial" 11]
                          ["Nuclear" "Industrial" 0]
                          ["Oil" "Residential & Commercial" 17]
                          ["Natural Gas" "Residential & Commercial" 76]
                          ["Coal" "Residential & Commercial" 1]
                          ["Renewable" "Residential & Commercial" 7]
                          ["Nuclear" "Residential & Commercial" 0]
                          ["Oil" "Electric Power" 1]
                          ["Natural Gas" "Electric Power" 18]
                          ["Coal" "Electric Power" 48]
                          ["Renewable" "Electric Power" 11]
                          ["Nuclear" "Electric Power" 22]]}])


(def sankey-data-2 [{:keys ["from" "to" "weight"]
                     :data [["Brazil" "Portugal" 5]
                            ["Brazil" "France" 1]
                            ["Brazil" "Spain" 1]
                            ["Brazil" "England" 1]
                            ["Canada" "Portugal" 1]
                            ["Canada" "France" 5]
                            ["Canada" "England" 1]
                            ["Mexico" "Portugal" 1]
                            ["Mexico" "France" 1]
                            ["Mexico" "Spain" 5]
                            ["Mexico" "England" 1]
                            ["USA" "Portugal" 1]
                            ["USA" "France" 1]
                            ["USA" "Spain" 1]
                            ["USA" "England" 5]
                            ["Portugal" "Angola" 2]
                            ["Portugal" "Senegal" 1]
                            ["Portugal" "Morocco" 1]
                            ["Portugal" "South Africa" 3]
                            ["France" "Angola" 1]
                            ["France" "Senegal" 3]
                            ["France" "Mali" 3]
                            ["France" "Morocco" 3]
                            ["France" "South Africa" 1]
                            ["Spain" "Senegal" 1]
                            ["Spain" "Morocco" 3]
                            ["Spain" "South Africa" 1]
                            ["England" "Angola" 1]
                            ["England" "Senegal" 1]
                            ["England" "Morocco" 2]
                            ["England" "South Africa" 7]
                            ["South Africa" "China" 5]
                            ["South Africa" "India" 1]
                            ["South Africa" "Japan" 3]
                            ["Angola" "China" 5]
                            ["Angola" "India" 1]
                            ["Angola" "Japan" 3]
                            ["Senegal" "China" 5]
                            ["Senegal" "India" 1]
                            ["Senegal" "Japan" 3]
                            ["Mali" "China" 5]
                            ["Mali" "India" 1]
                            ["Mali" "Japan" 3]
                            ["Morocco" "China" 5]
                            ["Morocco" "India" 1]
                            ["Morocco" "Japan" 3]]}])



