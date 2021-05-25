Find all the airports in a country which you cannot reach from a given city on the same day, no matter how many airports you have to hop through.
Implement a method with the following signature, Collection<String> getUnreachableAirports(String city)

Input: Airport code
Output: Unique list of airport codes which are not reachable on the same day

DataSet:

-------------------------------------------------------------------------------------------------------------------------------------------------
| AirlineCode | FlightNumber | FromAirportCode | FromAirportCountry | ToAirportCode | ToAirportCountry | DepartureTime | ArrivalTime |
--------------------------------------------------------------------------------------------------------------------------------------
|   AI         | 101           | AGR               | IN                   | HJR            | IN                |  1355           | 1440         |
|   AI         | 102           | AGR               | IN                   | JAI            | IN                |  1130           | 1325         |
|   AI         | 103           | AGX               | IN                   | BLR            | IN                |  1035           | 1345         |
|   9I         | 104           | AGX               | IN                   | BLR            | IN                |  1145           | 1505         |
|   AI         | 105           | AGX               | IN                   | BLR            | IN                |  1155           | 1505         |
|   AI         | 106           | AGX               | IN                   | COK            | IN                |  1035           | 1155         |
|   9I         | 107           | AGX               | IN                   | COK            | IN                |  1145           | 1300         |
|   AI         | 108           | AGX               | IN                   | COK            | IN                |  1155           | 1315         |
------------------------------------------------------------------------------------------------------------------------------------------------- 