## Understanding Git and Github / Online repositories

- Git: Version controlling system (Alternative: SVN)
- Guthub: Online project repository (Alternatives: GitLab, BitBucket)

## Important commands demonstrated

- `git status` : to see status of changes in currently working branch
- `git add .` : `.` represents all files in current branch. With `git add .` we can add all files to the staged situation (staged means files / changes ready to be committed)
- `git restore --staged .` : If we need any file to unstage
- `git commit -m "some commit message"` : We use git commit with some commit message to perform commit. We can only commit the staged files and commits are must before we want to publish (push) some changes to the remote repository.
- `git push` : We use git push to publish any committed changes in the working directory.