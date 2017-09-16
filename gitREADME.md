#Gitlab Setup Gude

*Windows*
1. Install chocolatey
2. Go to Powershell and type "choco install git"

*Mac*
1. Git should be preinstalled.

Then,
1. cd to a directory you want to clone the master branch in. E.g.,
```cd Desktop```
2. Then do the following
``` git init
    git clone https://gitlab.com/ftc-9656/relic-recovery.git
    git checkout -b firstNameLowercase
    ```
3. You now have a working personal branch of the master branch.

To recap--
Gitlab is like Google Docs for code, useful for collaboration.

The master branch is like the original master tree--all the good and published code goes there.
You guys make branches, clones of the original master tree. You guys can edit the codebase in your local branches and then push (publish) to the
online copy of your branches. Finally, you can push a merge request with the original master tree (if your revisions are good, then the master tree will
abosrb them with approval from an admin).
    
