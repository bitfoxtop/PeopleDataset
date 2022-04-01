# PeopleDataset

Here I provided a scala program to generate as many people data as you want.

The result can be redirected to a CSV file. I already generated a CSV which has 10k items in the data dir.

To load this data into Spark and print its schema:

    >>> df = spark.read.format("csv").option("inferSchema", "true").option("header", "true").load("PeopleDataset/data/people.csv")
    >>> df.printSchema()
    root
     |-- NAME: string (nullable = true)
     |-- SEX: string (nullable = true)
     |-- BORN: string (nullable = true)
     |-- ZIP: integer (nullable = true)
     |-- EMAIL: string (nullable = true)
     |-- JOB: string (nullable = true)
     |-- SALARY: double (nullable = true)

And here is a sample query with Spark's dataframe API:

    >>> df.groupBy("name").count().orderBy("count",ascending=False).show()
    +--------------+-----+
    |          name|count|
    +--------------+-----+
    |      Ali C.S.|    2|
    |     Ryan Q.T.|    2|
    |  Desmond M.Y.|    2|
    | Makenzie Z.Y.|    2|
    |  Maximus U.H.|    2|
    |     Jack I.S.|    2|
    |   Legend V.I.|    2|
    |    Major P.T.|    2|
    |   Easton P.X.|    2|
    |   Marcus H.M.|    2|
    |    Milan O.Z.|    2|
    |  Georgia Y.F.|    2|
    |     Nina H.S.|    2|
    |Alexandra V.L.|    2|
    |     Nora R.P.|    2|
    |    Derek T.H.|    2|
    |   Teagan L.X.|    2|
    |    Rhett Q.O.|    2|
    |   Colson S.Z.|    2|
    |     Erik Q.X.|    2|
    +--------------+-----+
    only showing top 20 rows

And then you could load it into Apache Drill for test as well:

    apache drill (dfs.pyh)> select name,sex,zip,job,salary from `people.csv` limit 5;
    +----------------+--------+-------+--------------------------------+---------+
    |      name      |  sex   |  zip  |              job               | salary  |
    +----------------+--------+-------+--------------------------------+---------+
    | Giovanni G.Y.  | Male   | 71478 | Sports Coach                   | 11817.0 |
    | Luke N.F.      | Male   | 74611 | Business Operations Manager    | 6751.0  |
    | Noel L.D.      | Male   | 13182 | Administrative Assistant       | 27694.0 |
    | Finley J.P.    | Female | 10263 | Patrol Officer                 | 27891.0 |
    | Genevieve A.I. | Female | 22954 | Diagnostic Medical Sonographer | 19717.0 |
    +----------------+--------+-------+--------------------------------+---------+
    5 rows selected (0.262 seconds)
