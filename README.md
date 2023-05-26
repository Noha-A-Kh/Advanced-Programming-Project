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
- we divided the project into two parts, the first part is for parsing the contents of the MDL file to extract the required information for each block and line like ID, name, position .... etc. the following pictures shows the parsed information of each block: 
![image](https://github.com/Noha-A-Kh/Advanced-Programming-Project/assets/125829152/29046c3a-8683-4823-87ef-fdc2a4a6c789)

- The Challenging part was parsing the branches inside each line because we were trying to find a patterned sequence to use in the parsing code, but eventually we managed to parse them correctly. the following picture shows the parssed information for each line:
![image](https://github.com/Noha-A-Kh/Advanced-Programming-Project/assets/125829152/f8dddd2d-7b46-4b2c-be10-e4716bd799db)  

- the second part was for developing the algorithm which would operate on the extraced raw information to update them to a usable representation in order to be able to pass them as proper parameters to be used in the GUI app. for example the following photo shows the updated parameters for a line and its branches so that they're represented in the form of start point x1,y1 and end point x2,y2 




