# Advanced-Programming-Project
Simulink Viewer  

The aim of this project is to develop a software tool that can read Simulink MDL files 
and display their contents in a user-friendly way using a Java-based graphical user 
interface (GUI) 
## *Team Members:* 
1) Noha Adel Desouky Khodier 2001407
2) Ahmed Hamed Ibrahim Hamed EL-Newehy 2000161
3) Youssef Mohammed Moustafa 2000122

## *Project Breakdown:* 
- we divided the project into three main parts, the first part is for parsing the contents of the MDL file to extract the required information for each block and each line like ID, name, position .... etc. the following picture shows the parsed information of each block: 
![image](https://github.com/Noha-A-Kh/Advanced-Programming-Project/assets/125829152/29046c3a-8683-4823-87ef-fdc2a4a6c789)

- The Challenging part was parsing the branches inside each line, because we were trying to find a patterned sequence to use in the parsing code, but eventually we managed to parse them correctly. the following picture shows the parsed information for each line:
![image](https://github.com/Noha-A-Kh/Advanced-Programming-Project/assets/125829152/f8dddd2d-7b46-4b2c-be10-e4716bd799db)  

- the second part was for updating the extracted raw information into a useful representation, for example calculating the start and end point of each line and branch and view them in the form of x1,y1 and x2,y2. in order to be able to pass this information as proper parameters to the GUI app. the following photo shows an example: 
![image](https://github.com/Noha-A-Kh/Advanced-Programming-Project/assets/125829152/600e8a46-ae99-402d-a9ff-b857b1560ac9)  





