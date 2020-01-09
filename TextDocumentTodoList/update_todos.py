"""
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

"""
import datetime

todo_filename = "Today's TODOs.txt"
log_filename = "todolist_history.txt"



# Persistent TODOs are located at the top of the file
persistent_todos = ["One Github Commit", "Respond to Emails"]
persistent_todos = ["\t" + todo for todo in persistent_todos]
new_contents = persistent_todos + []

completed_todos = []

with open(todo_filename) as file:
    i = 0
    for line in file:
        line = line.split('\t')
        if len(line) >= 2 and line[0] == "DONE":  # Gather completed todos, including persistent
            line[1] = line[1].replace('\n', '')
            line[1] = line[1].replace('\t', '')
            completed_todos.append(f"{datetime.datetime.now():%Y-%m-%d %H:%M:%S}\t{line[1]}")

        if i < len(persistent_todos):  # Prevent persistent todos from being copied to new file
            i += 1
            continue

        if len(line) < 2:  # Preserve newlines
            new_contents.append('')
        elif line[0] != "DONE":  # Gather incomplete todos
            line[1] = line[1].replace('\n', '')
            line[1] = line[1].replace('\t', '')
            new_contents.append('\t'.join(line))
        


with open(todo_filename, 'w') as file:
    file.write('\n'.join(new_contents))

if len(completed_todos) != 0:
    print('\n'.join(completed_todos))
    with open(log_filename, 'a') as file:
        file.write('\n')
        file.write('\n'.join(completed_todos))