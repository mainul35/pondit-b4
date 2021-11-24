## Understanding Git and Github / Online repositories

- Git: Version controlling system (Alternative: SVN)
- Guthub: Online project repository (Alternatives: GitLab, BitBucket)

## Important commands demonstrated
- `git init .` : initialize an empty git repository in local
- `git remote -v` : view remotes connected to the current local repository
- `git remote add <repo_alias_name_to_map> <repo_url>` : attach a remote url to current repository with an alias name for pull and push
- `git push --set-upstream origin <branch_name_we_want_to_create_in_remote>` : "branch_name_we_want_to_create_in_remote" refers to the branch name we want to push as a new branch in remote. This push will create a new branch in the remote and push the committed changes from local at the same time.
- `git pull <repo_alias_name> <branch_name>` : We can pull from the remote branch of a remote origin.
- `git status` : to see status of changes in currently working branch
- `git add .` : `.` represents all files in current branch. With `git add .` we can add all files to the staged situation (staged means files / changes ready to be committed)
- `git restore --staged .` : If we need any file to unstage
- `git commit -m "some commit message"` : We use git commit with some commit message to perform commit. We can only commit the staged files and commits are must before we want to publish (push) some changes to the remote repository.
- `git push` : We use git push to publish any committed changes in the working directory.

> A mandatory thing to remember is, you must pull after commit and before push. It will be helpful for avoiding mess ups of merge conflicts.