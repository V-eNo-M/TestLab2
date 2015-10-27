package TestLab2;

import java.util.ArrayList;

/**
 * Created by 1 on 13.10.2015.
 */
public class SearchPath {
    private boolean tabl[][];

    private ArrayList<Integer> path = new ArrayList<Integer>();
    private ArrayList<Integer> viewed = new ArrayList<Integer>();
    private ArrayList<String> manyPath = new ArrayList<String>();
    private String minPath = new String();
    private int start;
    private int end;
    private int nextIndex = 0;

    public SearchPath(boolean[][] t, int start, int end) {
        tabl = t;
        this.end = end - 1;
        this.start = start - 1;
        path.add(this.start);
    }

    public String notNullCheck() {
        String result = new String();
        for (int i = 0; i < tabl.length; i++) {
            for (int j = 0; j < tabl[i].length; j++) {
                if (tabl.length == tabl[i].length) {
                        result = "true";
                }
                else
                    result = "Error size";
            }
        }
        return result;
    }

    public String Main() {
        String err;
        String result;
        if(start != end) {
            if (this.end >= 0 && this.end < tabl.length && this.start >= 0 && this.start < tabl.length) {
                err = notNullCheck();
                    if (err.equals("true"))
                        result = startSearch();
                    else
                        return err;
            }
            else
                return "Not exist point start or end in this graph";
        }
         else return "Start = end";
        return result;

    }

    private String startSearch() {
        while(!path.isEmpty()) {
            if (path.get(path.size() - 1) != end) {
                search(nextIndex);
            } else {
                String m = path.toString();
                manyPath.add(m);
                if(path.get(path.size()-1) < tabl[0].length - 1)
                    nextIndex = path.get(path.size()-1) + 1;
                else {
                    path.remove(path.size()-1);
                    viewed.add(path.get(path.size() - 1));
                }
                path.remove(path.size() - 1);
            }
        }
        String result = minPath().toString();
        return result;
    }

    private void search(int in) {
        for (int i = in; i < tabl[0].length; i++) {
            if (tabl[path.get(path.size() - 1)][i] && !checkInPath(i) && !checkViewed(i)) {
                path.add(i);
                nextIndex = 0;
                break;
            } else if (i == tabl[0].length - 1 && (!tabl[path.get(path.size() - 1)][i] || checkViewed(i))) {
                if ((path.get(path.size() - 1) + 1 < tabl[0].length)) {
                    nextIndex = (path.get(path.size() - 1)) + 1;
                    viewed.add(path.get(path.size() - 1));
                } else {
                    nextIndex = path.get(path.size() - 1);
                    viewed.add(path.get(path.size() - 1));
                }
                path.remove(path.size() - 1);
                break;
            }
        }

    }

    private boolean checkViewed(int i) {
        boolean yesOrNo = false;
        for (Integer aViewed : viewed) {
            if (aViewed == i) {
                yesOrNo = true;
            }
        }
        return yesOrNo;
    }

    private boolean checkInPath(int i) {
        boolean yesOrNo = false;
        for (Integer aPath : path) {
            if (aPath == i) {
                yesOrNo = true;
            }
        }
        return yesOrNo;
    }

    private String minPath() {
        if(manyPath.size() > 0){
            minPath = manyPath.get(0).toString();
            for (int i = 1; i < manyPath.size(); i++) {
                if (minPath.length() > manyPath.get(i).length()) {
                    minPath = manyPath.get(i);
                }
            }
            return minPath;
        }
        return "Not path";
    }
}
