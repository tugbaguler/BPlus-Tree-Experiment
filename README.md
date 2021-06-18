# BPlus-Tree-Experiment
Experimenting the B+Tree

### Rules to follow:
Case 1:
1. Key-value pairs must be randomly generated only once for 500000 keys. 
2. E.g. 
   * Insert(1, 0.256)
   * Insert(7,5.789)
   * Insert(3,9.454)
   * ….


Case 2:
1. Key-value pairs must be generated in increasing order for 500000 keys. 
2. E.g.
   * Insert(1, 1.12)
   * Insert(2,1.13)
   * Insert(3,1.15)
   * Insert(4,1.16)
   * ….


Common rules:
1. The values must be floating point numbers in the range -1000.0 to +1000.0. 
2. You must use the same input file with different m value ranging from 5 to 50. 
3. Note that the same Insert commands should be used to build the B+Trees. 
4. After you build the tree structure, initially create a list of 100 randomly generated search queries 
to find individual key values.
5. You must use the same search query (100 searches) for different m values.
