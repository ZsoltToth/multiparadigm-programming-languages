package hu.ekcu.java.service;

import java.util.Collection;
import java.util.HashSet;

public class ArraySplitterImpl implements ArraySplitter {

    @Override
    public Collection<ArraySlices> split(String[] array, int groupCount) {
        Collection<ArraySlices> result = new HashSet<>();
        result.addAll(split(array, groupCount, new ArraySlices()));
        return result;
    }

    /**
     * Overloaded method is hidden.
     * Recursion requires the prefix argument which is not part of the public method.
     * Public method wraps the private recursive implementation.
     *
     * @param array
     * @param groupCount
     * @param prefix
     * @return
     */
    private Collection<ArraySlices> split(String[] array, int groupCount, ArraySlices prefix){
        Collection<ArraySlices> result = new HashSet<>();
        if(groupCount == 0){
            return result;
        }
        for(int i = 1; i < array.length; i++){
            if(!array[0].equals(array[i])){
                continue;
            }

        }
        return result;
    }

    protected String[][] splitArrayAtIndex(String[] array, int index){
        String[] head = new String[index+1];
        String[] tail = new String[array.length - (index+1)];
        for(int i = 0; i < array.length; i++){
            if(i < head.length) {
                head[i] = array[i];
            }
            else{
                tail[i- head.length] = array[i];
            }
        }
        return new String[][] {head, tail};
    }
}
