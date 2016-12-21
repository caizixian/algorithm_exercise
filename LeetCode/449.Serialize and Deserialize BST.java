public class Codec {
    class Result {
        int end;
        TreeNode body;

        Result(int end, TreeNode body) {
            this.end = end;
            this.body = body;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[").
                    append(root.val).
                    append(serialize(root.left)).
                    append(serialize(root.right)).
                    append("]");
            return sb.toString();
        }
    }

    private Result deserialize(String data, int start) {
        StringBuilder valSb = new StringBuilder();
        int i;
        int j = 0;
        TreeNode[] branch = new TreeNode[2];
        for (i = start; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch == '[' && i != start) {
                Result r = deserialize(data, i);
                i = r.end;
                branch[j] = r.body;
                j++;
            }
            if (ch == ']') {
                break;
            }
            if (ch == '#') {
                branch[j] = null;
                j++;
            }
            if (Character.isDigit(ch) || ch == '-') {
                valSb.append(ch);
            }
        }
        if (valSb.length() == 0) {
            return new Result(i, null);
        }
        TreeNode root = new TreeNode(Integer.parseInt(valSb.toString()));
        root.left = branch[0];
        root.right = branch[1];
        return new Result(i, root);
    }

    public TreeNode deserialize(String data) {
        return deserialize(data, 0).body;
    }
}