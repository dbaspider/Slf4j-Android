# Slf4j-Android
This is a SLF4J Android demo project.

-------------
SLF4J Android
-------------
The motivation for the SLF4J Android project was to ease using existing libraries which use SLF4J as their logging framework on the Google Android platform.

This project is basically a (i) repackaging of the SLF4J API part, together with (ii) a very lightweight binding implementation that simply forwards all SLF4J log requests to the logger provided on the Google Android platform. The API part is compiled from the same code basis of the standard distribution. This is the reason why we decided to keep the version numbering in sync with the standard SLF4J releases in order to reflect the code basis from which it was built.

------
Status
------
The implementation is currently fully functional but has not yet been fully tested in a production environment. Let us know if you have used it in production!

See http://www.slf4j.org/android/ for more.

----------
TO-DO-LIST
----------
1. File logger support;
2. File rolling, size limit;
3. Logger config;
4. ...
