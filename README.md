# PeopleDataset

Here I provided a scala program to generate as many people data as you want.

The data columns: name,born,sex,tel,job

The result can be redirected to a CSV file. I already generated a CSV which has 100k items in the data dir.

To load data into pyspark:

>>> df = spark.read.format("csv").option("inferSchema", "true").option("header", "true").load("/path/people.csv")

And here is a sample query with Spark's dataframe API:

>>> df.groupBy("name").count().orderBy("count",ascending=False).show()
+------------+-----+                                                            
|        name|count|
+------------+-----+
|Cameron Y.B.|   12|
|   Remy L.A.|   11|
| Alexis L.I.|   11|
| Sawyer P.P.|   11|
|  Eliza N.R.|   11|
|  Blake K.X.|   11|
|  Dylan Y.C.|   11|
|  Rowan K.S.|   11|
| Alexis G.F.|   10|
|   Ruth E.M.|   10|
| Jordan Q.S.|   10|
|   Remy T.D.|   10|
|   Rory W.A.|   10|
|Charlie S.U.|   10|
|  Logan N.R.|   10|
|   Rory F.I.|   10|
| Oakley I.I.|   10|
|   Ryan H.B.|   10|
| Peyton H.K.|   10|
|  Avery R.H.|   10|
+------------+-----+
only showing top 20 rows
