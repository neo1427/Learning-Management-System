# WELCOME TO LEARNING MANAGEMENT SYSTEM! 
This is a starter repository made specifically for learning.

If you're a beginner and you've come looking for your first contribution, we are here to help.\
We've provided the instructions for you to get started with contributing to Open Source. Scroll down for more info.

## Prerequisites
### 1. Install Git on your computer.

Firstly, install Git onto your local system. If you are on linux or mac, you get Git pre-installed.\
However, if you are on Windows you will have to install it. To do so, click [here](https://git-scm.com/).

### 2. Creating a GitHub account.

Head over to [GitHub.com](https://github.com) and create an account by signing up.

### 3. Now what?

Open sourcing and contributing to the free internet is what drives the internet today, and everyone and every single contribution is appreciated in the Open Source world.\
And, you can join us with your first pull request right here!

## First pull request to Glory
### 1. Star and Fork this Repository
You can star and fork this repository on GitHub at the top of the repository.

Forking allows you to create a version of the repository for yourself.\
This allows you to make changes to the repository without requiring any permissions or interfering with the existing repository.\
Now, redirect yourself to your fork of the repository, which should have a URL like so,
> https://github.com/neo1427/Learning-Management-System

### 2. Clone the repository to your local computer
To make your own copy of the repository that you would want to contribute to, you'll need to clone it to your system for easier access.
Using the `git clone` commmand, you could clone the repository to your local system.
While the URL would essentially be like,
> https://github.com/neo1427/Learning-Management-System.git

After which, just direct yourself to whichever place you wish to clone the repository to using the change directory or `cd` command in terminal and then `git clone` your project.

### 3. Create a New Branch

Direct yourself into the repository using `cd Learning-Management-System/`.
Now, we'll create and switch onto the branch that we will be working on, for editing file in the project.

Creating a branch,
```git
git branch branch-name
```

Switching from main branch to another branch,
```git
git checkout branch-name
```

Viewing all the available branches for your repository,
```git
git branch -a
```

### 4. Contribute!

We can finally get to contributing to the repository now!

### 5. Committing the changes

You can add all the files that you've updated using the command `git add -A`\
Then, you commit to save the files, like how you would at a checkpoint, `git commit -m "added myself"`

Now, you want to push to your fork online, that works with `git push origin branch-name`.

### 6. Updating the local repository

It is important to keep your local repository updated with the project in order to avoid merge conflicts. To do this, you'll have to configure a remote for the fork and then sync the fork.

#### Configuring a Remote for the fork

In order to create a remote for the fork, you'll need to specify a new remote upstream repoistory (the repository you forked from) to sync with the fork. You'll be using the `git remote add` command to do that.

<pre>git remote add upstream https://github.com/neo1427/Learning-Management-System.git</pre>

**Note**: We have referenced the original repository as "upstream".

#### Syncing the fork

Once the remote references to the original repository you forked from, you are ready to sync changes in order to keep your local copy up to date. To do this, we use the `git fetch` command.

<pre>git fetch upstream</pre>

Once done, you need to switch back to the main branch, you can do this using

<pre>git checkout main</pre>

Now, merge changes made from the original repository's main branch with your current local ,main branch using

<pre>git merge upstream/main</pre>

### 7. Making the pull request

Once your local repository is updated, you are all set to send us a pull request.

To do that, just open your forked repository and click on pull request, now you can see a green button that says "New pull request".

Create the pull request and lay back and relax until you receive a notice signifying the acceptance of your pull request or, the request to modify your changes.

**Note** : If you have any question regarding any of the steps above or about anything related to this repository, just create an issue.

# *Get, Set, Contribute!*
