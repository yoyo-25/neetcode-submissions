class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> list = new ArrayList<>();
        int j=0;

        while(j<str.length()){
            StringBuilder sb = new StringBuilder();

            while(str.charAt(j) != '#'){
                sb.append(str.charAt(j));
                j++;
            }

            int k = Integer.parseInt(sb.toString());

            j++;
            list.add(str.substring(j, j+k));
            j += k;
        }

        return list;
    }
}
