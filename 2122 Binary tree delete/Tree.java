class Tree<E extends Comparable<E>> {
    private TreeNode<E> root;

    Tree(){
        root = null;
    }

    void insertNode(E insertValue) {
        if (root == null) {
            root = new TreeNode<>(insertValue);
        } else{
            root.insert(insertValue);
        }
    }

    void inorderTraversal() {
        inorderHelper(root);
    }

    private void inorderHelper(TreeNode<E> node){
        if (node == null){
            return;
        }

        inorderHelper(node.leftNode);
        System.out.printf("%s ", node.data);
        inorderHelper(node.rightNode);
    }

    void deleteNode(E value){
        TreeNode<E> parriarch;
        TreeNode<E> castaway;

        // if castaway is root, or no value exists in tree
        if(root == null || root.data.equals(value)){
            parriarch = null;
            castaway = root;
        } else{
            parriarch = getParriarch(value);
            castaway = getCastaway(parriarch, value);
        }

        TreeNode<E> adoptee = getAdoptee(parriarch, castaway);
        TreeNode<E> orphan = getOrphan(castaway, adoptee);
        TreeNode<E> foster = getFoster(castaway, adoptee);

        // case 0: value does not exist, castaway is null - print message, do nothing
        if(castaway == null){
            System.out.printf("%s not found.", value);
        }
        // case 1: value is root, parriarch is null - adoptee becomes root, orphan to foster
        else if(parriarch == null){
            root = adoptee;
            attachOrphan(orphan, foster);
        }
        // case 2: castaway has no children, adoptee is null - null replaces castaway
        else if(adoptee == null){
            replaceCastaway(castaway, parriarch, null);
        }
        // case 3: castaway has no orphan, orphan is null - adoptee replaces castaway
        else if(orphan == null){
            replaceCastaway(castaway, parriarch, adoptee);
        }
        // case 4: castaway has two children - adoptee replaces castaway, orphan to foster
        else{
            replaceCastaway(castaway, parriarch, adoptee);
            attachOrphan(orphan, foster);
        }
    }

    private TreeNode<E> getParriarch(E value){
        if(root != null && !root.data.equals(value)){
            TreeNode<E> parriarch = root;
            while(parriarch != null){
                if((parriarch.leftNode != null && parriarch.leftNode.data.equals(value)) ||
                        (parriarch.rightNode != null && parriarch.rightNode.data.equals(value))){
                    return parriarch;
                } else if(value.compareTo(parriarch.data) < 0){
                    parriarch = parriarch.leftNode;
                } else{
                    parriarch = parriarch.rightNode;
                }
            }
        }
        return null;
    }

    private TreeNode<E> getCastaway(TreeNode<E> parriarch, E value){
        if(parriarch == null){
            return null;
        } else if(parriarch.leftNode != null &&
                parriarch.leftNode.data.equals(value)){
            return parriarch.leftNode;
        } else{
            return parriarch.rightNode;
        }
    }

    private TreeNode<E> getAdoptee(TreeNode<E> parriarch, TreeNode<E> castaway){

        if(castaway == null || (castaway.leftNode == null && castaway.rightNode == null)){
            return null;
        } else if((parriarch == null || castaway.data.compareTo(parriarch.data) < 0) &&
                castaway.leftNode != null){
            return castaway.leftNode;
        } else{
            return castaway.rightNode;
        }
    }

    private TreeNode<E> getOrphan(TreeNode<E> castaway, TreeNode<E> adoptee){
        if(castaway == null || adoptee == null){
            return null;
        }
        else if(adoptee == castaway.leftNode){
            return castaway.rightNode;
        } else{
            return castaway.leftNode;
        }
    }

    private TreeNode<E> getFoster(TreeNode<E> castaway, TreeNode<E> adoptee){
        TreeNode<E> foster = adoptee;

        if(castaway == null || adoptee == null){
            foster = null;
        }
        else if(adoptee.data.compareTo(castaway.data) > 0) {
            // foster is on the left side of the right tree
            while(foster.leftNode != null){
                foster = foster.leftNode;
            }
        }
        else{
            // foster is on the right side of the left tree
            while(foster.rightNode != null){
                foster = foster.rightNode;
            }
        }
        return foster;
    }

    private void attachOrphan(TreeNode<E> orphan, TreeNode<E> foster){
        if(orphan.data.compareTo(foster.data) < 0){
            foster.leftNode = orphan;
        } else{
            foster.rightNode = orphan;
        }
    }

    private void replaceCastaway(TreeNode<E> castaway, TreeNode<E> parriarch, TreeNode<E> adoptee){
        if(castaway.data.compareTo(parriarch.data) < 0){
            parriarch.leftNode = adoptee;
        } else{
            parriarch.rightNode = adoptee;
        }
    }
}
