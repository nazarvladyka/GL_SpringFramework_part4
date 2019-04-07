# GL_SpringFramework_part4

To start application you just need to run <b>main</b> method in JsonDBApplication.class.
So now apllication start on your computer on port <b>8080</b>.

If you want to try functions, or just play with this app you need to know a few requests which app can receive:

1) http://localhost:8080/heroes/add/{heroId} - just enter this url and ID of hero which you want to add (1..87) to DB.
2) http://localhost:8080/heroes/{id} - with this comand you can get hero form DB.
3) http://localhost:8080/heroes/list - if you enter this command you will gat a full list of heroes which now registered in DB.
4) http://localhost:8080/heroes/{heroId1}/istaller/{heroId2} - and this command is a main biz logic, this cammand will return who is taller from these two heroes and is he taller than avarage hero from his planet.

And yes, in this project you will not find any test's)
