# About 
This is the GitHub repository of smtcodan-engine symbolic execution engine. This can be used to analyze C/C++ source code. It is build on top of the Elcipse CDT Codan engine.
See here, for more details.
* https://wiki.eclipse.org/CDT/designs/StaticAnalysis 
* http://help.eclipse.org/kepler/index.jsp?topic=%2Forg.eclipse.ptp.pldt.doc.user%2Fhtml%2Fcodan.html


Smtcodan uses a satisfiable modulo theories (SMT) solver. Currently we use the z3 solver from Microsoft Research but also other solvers can be used. Each checker attached to the engine checks the generated constrains along the analyzed execution path. The engine is developed as an Eclipse plug-in and can be deployed in another Eclipse CDT
instance in order to check for different types of bugs.  The engine contains at this moment of development 5 branches, master, infoFlowChecker, IntegerFlowCheckerQuickFixes, BugLoc and extended. The integer overflow checker along with the repair generation functionality is contained in the IntegerFlowCheckerQuickFixes branch. See underneath for the particular branch description.

## Publication
* https://ieeexplore.ieee.org/abstract/document/8862860 or
* https://www.in.tum.de/fileadmin/w00bws/cybertrust/papers/2019-TSE-Muntean.pdf

# Demo Movies
* Detection of Integer Overflows in C/C++ Source Code
  [![pic5.png](https://i.postimg.cc/8zH2jbPQ/pic5.png)](https://goo.gl/EqNKCD)

* Repair of Integer Overflows in C/C++ Source Code 
  [![pic6.png](https://i.postimg.cc/Y91fCdMQ/pic6.png)](https://goo.gl/D4NPp6)


# Source Code Branches
* __master__:contains the integer overflow checker, and the integer overflow checker quick-fix functionality.
see Video: https://www.youtube.com/watch?v=4iAYxea7cZo

# Folder Contents
* __EclipseVersion__: contains the archived Eclipse Version (Kepler) which was used with the smtcodan engine.
* __smtcodan__: is the main folder of the engine. It contains the plug-in main class and the interface to the SMT solver. Here the control flow graph
is build and then using different threads each path is traversed and checked w.r.t. different types of constrains along the path. Basically each
program execution path is traversed in a context-sensitive manner and path reachability and checker (e.g., int. overflow, buffer overflow, infinite loop, 
race condition, etc.) constrains are checked along each path. Also, in the class Config.java many settings of the implemented algorithms can be set. For example
the number of loops unrolling can be here set.
* __checkers__: contains all the available checkers such as the integer overflow checker. 
* __checkers/tests__: contains several jUnit test cases for the checkers from above.
* __environemnt__: contains environment function models (e.g., atoi(), connect(), abs(), close(), fgets(), etc.). The behaviour of different functions can be modeled with this functions stubs. 
The goal is to be able during symbolic execution to approximate the real behavior of a real environment function.
* __interpreter__: contains the engine interpreter. The interpreter is responsible for retrieving symbolic variables along the analyzed contexts.
* __logger__: contains basic logging functionality. The logging can be directed to the console or a file for example.
* __multithreadanalysis__: conatains the functionality used for performing race condition checking. This engine functionality is basically used only by the race condition checker.
* __multithreadanalysis/checkers__: contains the race condition checker.
* __multithreadanalysis/checkers/tests__: contains jUnit test cases for the multithreaded functionalities of the engine.
* __parser__: contains an ANTLR based parser for extracting code annotations which can serve in order to indicate important analysis nodes along the program execution paths. Such nodes can be 
anotated as sinks or sources for example.
* __pathgen__: contains functionality for building a program execution path. After the control flow graph was build execution paths have to be extracted 
such that the analysis to have on what to work. These program execution paths are extracted with the help of these classes.
* __progressthreads__: contains experimental functionality for building a progress execution bar for real-time execution estimation of the time 
needed by the engine to finish his current assigned job. This estimation (heuristic) is determined by analyzing the program execution tree and the number
of contained nodes.
* __quickfixes__: contains classes which handle the data which will be displayed in the quick-fixing user interface window during the insertion 
of an bug quick fix.
* __quickfixes/introduceimpl__: contains the refactoring wizard with his main functionality. Basically the transitions of windows between each 
quick fxing window can be set in the contained classes.
* __quickfixes/introduceimpl/actions__: contains the actions which can be associated to each of the user interfaces which can help the 
user to insert his quick-fixes.
* __quickfixes/introduceimpl/node__: contains additional functionality used for developing user interfaces which can be used
during quick-fix insertion.
* __quickfixes/introduceimpl/ui__: contains the Language Tool Kit (LTK) user interfaces. It is possible to build an user interface
for each bug checker.
* __symvars__: contains all types of used symbolic variables inside our engine. Basically, we have for each variable a single static assignment (SSA) and
an original (Orig) version of the variable.
* __tests__: contains several jUnit tests for different features of the engine.
* __translator__: contains the statement processor class. This contains a visitor used for visiting the AST bottom-up of
each statement along an execution path in order to build SMT statements for each encountered symbolic variable inside the AST.
In case the translated variable was declared in a different context, (e.g., in another function or file) than the interpreter
is used in order to retrieve the symbolic counterpart variable and attach the SMT constrains to that variable rather than creating a new
symbolic variable.
* __util__: contains an utility for measuring execution times during engine runtime.
* __vizualization__: contains some classes used to build and program execution tree and
then dispaly this as and svg picture.

# Notice
* __quick fixes__: After applying a repair (quick-fix) to a program you need to re-index the program again such that the code change become visible for
the parser and the C/C++ AST builder. In order to do this click right on the program project folder and select from the drop-down menu Index->Rebuild or Build Project.
This will re-index the project again and the quick-fix becomes visible. If you re-run the integer overflow checker for example on the re-index program than the 
bug should be gone.
* __quick fixes types__: For integer overflow bugs (CWE-190) only in-place quick-fixes are available whereas for buffer overflows there are in-place and not in-place quick
fixes available.

# ToDos:
* __z3 solver interface__: Due to the fact that our engine communicates with the z3 solver via Java input/output stream buffers makes this interface rather slow. In order to make the
engine faster this interface should be replaced with another one in which the solver is directly queried from Java code without the use of any proxy
interfaces. The expected performance gain is: 10x up to 100x.
* __C/C++ statement translation to SMT logic__: The component which translates symbolic values to SMT constraints (i.e., SmProcessor.java class, the statement processor class) should be first, extended such that the whole C (if need C++) is
supported and second, this visitor class should be refactored such that maintainability and extendability becomes easier.
* __repair multiple integer overflow errors at the same time__: currentyly each integer overflow can be fixed only one by one. In order to make this functionality work for multiple bug reports
each bug report has to be associated to his repair. The simplest way to address this is to maintain a list with all the generated reports and associate the filename and line number where the 
bug was detected with the type of repair which should be applied.

# Requirements:
* Please see the requirements folder in order to see what packages need to be previously installed in Eclipse.
* We tested the engine with Eclipse Kepler SR1.
* Insert the z3 solver into your local path.
* Notice that on Ubuntu OS 14.04 LTS it is sufficient to put the z3 executable in the home/bin folder.
* The z3 SMT solver is available at: https://z3.codeplex.com/

# Installation/Building

1. Import the smtcodan engine, Jung and Batik plug-ins into the Eclipse JDT.
2. Make sure there are no errors after you imported the plug-ins.
3. Notice that Jung and Batik are just for drawing so these plug-ins can be later disabled if not needed.
4. After successful importing the smtcodan engine, click-right on the smtcodan plug-in and select from the menu run as -> Eclipse application.
5. Next a second Eclipse CDT instance should start. In this Eclipse CDT instance the smtcodan plug-in should be deployed and available. Please check which plug-ins are available. Make sure that the smtcodan plug-in is available.
6. Import in the second Eclipse CDT the programs from the workspace, for e.g., CWE_190_Total_Workspace_ISSA15_Papier.zip.
7. make sure the Eclipse CDT Problems window is visible. If not make it available/visible by activating it from the "View" menu.
8. Select one or more programs from the workspace and then click right and select "Run C/C++ Analysis" from the menu.
9. The analysis should run. Some analysis output should be shown in the console window.
10. The detected bugs will be listed in the Problems window, 
11. A bug report will be generated for each and a bug icon will be placed in the line number where the bug was detected.

# Authors
* tba, www: tba
* tba, www: tba

# Research Papers

* Paul Muntean, Martin Monperrus, Hao Sun, Jens Grossklags and Claudia Eckert, "[IntRepair: Informed Repairing of Integer Overflows](http://arxiv.org/pdf/1807.05092)", In IEEE Transactions on Software Engineering, 2019. 

```
@article{arXiv-1807.05092,
 title = {IntRepair: Informed Repairing of Integer Overflows},
 journal = {IEEE Transactions on Software Engineering},
 year = {2019},
 doi = {10.1109/tse.2019.2946148},
 author = {Paul Muntean and Martin Monperrus and Hao Sun and Jens Grossklags and Claudia Eckert},
 url = {http://arxiv.org/pdf/1807.05092},
}
```

* P. Muntean, M. Rahman, A. Ibing, and C. Eckert. SMT-Constrained Symbolic Execution Engine for Integer Overflow Detection in C Code. In International Information Security South Africa Conference (ISSA), Johannesburg, South Africa, August 2015. IEEE Computer Society.

```
@conference{364,
  author = {Muntean, Paul and Rahman, Mustafizur, and Ibing, Andreas and Eckert, Claudia},
  title = {SMT-Constrained Symbolic Execution Engine for Integer Overflow Detection in C Code},
  booktitle = {International Information Security South Africa Conference (ISSA), Johannesburg, South Africa},
  year = {2015},{enter}
  publisher = {IEEE Computer Society},
  month = aug,
  url = {https://www.sec.in.tum.de/assets/staff/muntean/issa2015.pdf}
}
```

* P. Muntean, V. Kommanapalli, A. Ibing, and C. Eckert. Automated Generation of Buffer Overflows Quick Fixes using Symbolic Execution and SMT. In International Conference on Computer Safety, Reliability & Security (SAFECOMP), Delft, The Netherlands, September 2015. Springer LNCS.

```
* @conference{358,

  author = {Muntean, Paul and Kommanapalli, Vasantha, and Ibing, Andreas and Eckert, Claudia},
  
  title = {Automated Generation of Buffer Overflows Quick Fixes using Symbolic Execution and SMT},
  
  booktitle = {International Conference on Computer Safety, Reliability & Security (SAFECOMP), Delft, The Netherlands},
  
  year = {2015},
  
  publisher = {Springer LNCS },
  
  month = sep,
  
  url = {https://www.sec.in.tum.de/assets/staff/muntean/safecomp15.pdf}
  
}
```

* P. Muntean, A. Rabbi, A. Ibing, C. Eckert, Automated Detection of Information Flow Vulnerabilities in UML State Charts and C Code. In QRS Companion 2015.

```
@conference{361,

  author = {Muntean, Paul and Rabbi, Adnan and Ibing, Andreas and Eckert, Claudia},
  
  title = {Automated Detection of Information Flow Vulnerabilities in UML State Charts and C Code},
  
  booktitle = {International Conference on Software Quality, Reliability and Security Companion (QRS-C), Vancouver, Canada},
  
  year = {2015},
  
  publisher = {IEEE Computer Society},
  
  month = aug,
  
  url = {https://www.sec.in.tum.de/assets/staff/muntean/MVV_Automated_Detection_of_Information_Flow0AVulnerabilities_in_UML_State_Charts_and_C_Code.pdf}
  
}
```

* P. Muntean, C. Eckert, A. Ibing, Context-sensitive detection of information exposure bugs with symbolic execution. In InnoSWDev@SIGSOFT FSE Workshop, 2014.

```
@conference{340,
  author = {Muntean, Paul and Eckert, Claudia and Ibing, Andreas},
  
  title = {Context-sensitive Detection of Information Exposure Bugs with Symbolic Execution},
  
  booktitle = {International Workshop on Innovative Software Development Methodologies and Practices (InnoSWDev), Hong Kong, China},
  
  year = {2014},
  
  publisher = {ACM},
  
  month = nov,
  
  url = {https://www.sec.in.tum.de/assets/staff/muntean/InnoSWDev_14_Context-Sensitive_Detection_of_Information_Exposure_Bugs_with_Symbolic_Execution.pdf}

}
```


* A. Ibing, SMT-Constrained Symbolic Execution for Eclipse CDT/Codan. In SEFM Workshops 2013.

```
@inproceedings{DBLP:dblp_conf/sefm/Ibing13,

   author              = {Andreas Ibing},
   
   title               = {SMT-Constrained Symbolic Execution for Eclipse CDT/Codan.},
   
   booktitle           = {SEFM Workshops},
   
   year                = {2013},
   
   pages               = {113-124},
   
   ee                  = {http://dx.doi.org/10.1007/978-3-319-05032-4_9},
   
   crossref            = {2013},
   
}
```

* A. Ibing, Parallel SMT-Constrained Symbolic Execution for Eclipse CDT/Codan. In ICTSS 2013.

```
@inproceedings{conf/pts/Ibing13,

  added-at = {2013-11-26T00:00:00.000+0100},

  author = {Ibing, Andreas},

  biburl = {http://www.bibsonomy.org/bibtex/240e05fc4d4943d35255e7cfcb2c20bc3/dblp},

  booktitle = {ICTSS},

  crossref = {conf/pts/2013},

  editor = {Yenigün, Hüsnü and Yilmaz, Cemal and Ulrich, Andreas},

  ee = {http://dx.doi.org/10.1007/978-3-642-41707-8_13},

  interhash = {616ddfff81eeae2899ba93c8b36d77dd},

  intrahash = {40e05fc4d4943d35255e7cfcb2c20bc3},

  isbn = {978-3-642-41706-1},

  keywords = {dblp},

  pages = {196-206},
  publisher = {Springer},

  series = {Lecture Notes in Computer Science},

  timestamp = {2013-11-27T11:34:45.000+0100},

  title = {Parallel SMT-Constrained Symbolic Execution for Eclipse CDT/Codan.},
  
  url = {http://dblp.uni-trier.de/db/conf/pts/ictss2013.html#Ibing13},

  volume = 8254,

  year = 2013
  
}
```

* A. Ibing, Path-Sensitive Race Detection with Partial Order Reduced Symbolic Execution. In SEFM Workshops 2014.

```
@inproceedings{DBLP:dblp_conf/sefm/Ibing14,
   
   author              = {Andreas Ibing},
   
   title               = {Path-Sensitive Race Detection with Partial Order Reduced Symbolic Execution.},
   
   booktitle           = {SEFM Workshops},
   
   year                = {2014},
   
   pages               = {311-322},
   
   ee                  = {http://dx.doi.org/10.1007/978-3-319-15201-1_20},
   
   crossref            = {2014},
   
}
```

* A. Ibing, Alexandra Mai, A Fixed-Point Algorithm for Automated Static Detection of Infinite Loops. In HASE 2015.

```
@inproceedings{404,

  author = {A. Ibing and A. Mai},
  
  title = {A Fixed-Point Algorithm for Automated Static Detection of Infinite Loops},
  
  booktitle = {IEEE Int. Symp. High Assurance Systems Eng.},
  
  year = {2015},
  
  month = jan,
  
  url = {https://www.sec.in.tum.de/assets/Uploads/ibing15infloops.pdf}
  
}
```

* A. Ibing, Architecture description language based retargetable symbolic execution. In DATE 2015.

```
@inproceedings{DBLP:dblp_conf/date/Ibing15,

   author              = {Andreas Ibing},
   
   title               = {Architecture description language based retargetable symbolic execution.},
   
   booktitle           = {DATE},
   
   year                = {2015},
   
   pages               = {241-246},
   
   ee                  = {http://ieeexplore.ieee.org/xpl/freeabs_all.jsp?arnumber
   
   crossref            = {2015},
   
}
```

* A. Ibing, Efficient Data-Race Detection with Dynamic Symbolic Execution. In FedCSIS 2016.

```
@inproceedings{435,
  
  author = {A. Ibing},
  
  title = {Efficient Data-Race Detection with Dynamic Symbolic Execution},
  
  booktitle = {IEEE Software Engineering Workshop},
 
  year = {2016},
 
  month = sep,
 
  url = {https://www.sec.in.tum.de/assets/Uploads/ibing16races.pdf}
  
}


* A. Ibing, Julian Kirsch, Lorenz Panny, Autocorrelation-Based Detection of Infinite Loops at Runtime. In DASC/PiCom/DataCom/CyberSciTech 2016.

```
@inproceedings{433,

  author = {A. Ibing and J. Kirsch and L. Panny},
  
  title = {Autocorrelation-Based Detection of Infinite Loops at Runtime},
  
  booktitle = {IEEE Int. Conf. Dependable, Autonomic and Secure Computing},
  
  year = {2016},
  
  month = aug,
  
  url = {https://www.sec.in.tum.de/assets/Uploads/dynloops.pdf}
  
}
```
# License
MIT License

Copyright (c) 2017

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
