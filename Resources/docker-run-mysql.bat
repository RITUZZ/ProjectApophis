echo off
echo Starting MySQL, root password=ppp
docker run -p 3306:3306 --name mysql-populated -e MYSQL_ROOT_PASSWORD=ppp -d mysql-db-unpopulated:latest
echo MySQL container now running
echo 

echo Copying sql script to create tables
docker cp db_grad_cs_1917_2.sql mysql-populated:/root
docker cp init-populate-mysql-db.sh mysql-populated:/root
docker cp create-db-teams-and-lectures-for-2017.sql mysql-populated:/root
echo 

echo Waiting for MySQL deamon to initialise, do not interrupt... (CTRL+C will termiate the install)
timeout 30 /NOBREAK

echo Initialising and populating the DB, can take approximately 5 minutes to complete, please wait...
docker exec -it mysql-populated bash -c "cd /root; ./init-populate-mysql-db.sh"
echo MySQL available for use...
echo  
