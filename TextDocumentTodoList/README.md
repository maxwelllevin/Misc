Script to update a TODOs text file. 

Clears tasks marked as DONE and resets todo items marked as persistent (in this file).

Keeps a history of completed todos in the log file.

Can be run automatically at log-in or at an interval by using task scheduler on Windows.
Additional task scheduler instructions:
1. Create Task
2. Configure Triggers (Simple enough)
3. Configure Actions (NO QUOTES):
    Program/script: python
    Add Arguments (optional): update_todos.py
    Start in (optional): D:\Desktop - Hard Drive\ 