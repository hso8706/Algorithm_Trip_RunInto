package com.ssafy.service;

import com.ssafy.vo.Attraction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.google.common.collect.ComparisonChain;


public class AttractionServiceImpl {


    public List<Attraction> sort(List<Attraction>  attractions, SortType sortType){


        if(sortType.equals(SortType.TITLE)){ // 이름기준으로 정렬

            Collections.sort(attractions, (o1, o2) -> ComparisonChain.start()
                .compare(o1.getTitle(), o2.getTitle())
                .result());
            return attractions;
        }

        if(sortType.equals(SortType.VIEW)){ // 조횟수 기준으로 정렬
           Attraction[] sorted=attractions.toArray(new Attraction[attractions.size()]);
           timSort(sorted,attractions.size());
           return Arrays.asList(sorted);
        }

        return null;
    }


    public List<Attraction> search(List<Attraction>  attractions, String searchWord) {

        char[] pattern = searchWord.toCharArray();
        int pLength = pattern.length;

        int[] pi = new int[pLength];

        for(int i=1, j=0; i<pLength; i++){
            while(j > 0 && pattern[i] != pattern[j]) j = pi[j-1];

            if(pattern[i] == pattern[j]) pi[i] = ++j;
            else pi[i] = 0;
        }

        List<Attraction>  filteredAttractions=new ArrayList<>();

        for (int k = 0; k < attractions.size() ; k++) {

            char[] text = attractions.get(k).getOverview().toCharArray();
            int tLength = text.length;


            for(int i=0,j=0; i<tLength; ++i) {

                while(j>0 && text[i] != pattern[j]) j = pi[j-1];

                if(text[i] == pattern[j]) { //두 글자 일치
                    if(j == pLength-1) { // j가 패턴의 마지막 인덱스라면
                        filteredAttractions.add(attractions.get(i));
                        break; // 존재 여부만 검사
                    }else {
                        j++;
                    }
                }
            }

        }

        return filteredAttractions;

    }


    static int MIN_MERGE = 32;

    public static int minRunLength(int n)
    {
        assert n >= 0;

        // Becomes 1 if any 1 bits are shifted off
        int r = 0;
        while (n >= MIN_MERGE)
        {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    // This function sorts array from left index to
    // to right index which is of size atmost RUN
    public static void insertionSort(Attraction[] arr, int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            Attraction temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j].compareTo(temp) > 0)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Merge function merges the sorted runs
    public static void merge(Attraction[] arr, int l,
        int m, int r)
    {
        // Original array is broken in two parts
        // left and right array
        int len1 = m - l + 1, len2 = r - m;
        Attraction[] left = new Attraction[len1];
        Attraction[] right = new Attraction[len2];
        for (int x = 0; x < len1; x++)
        {
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++)
        {
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        // After comparing, we merge those two array
        // in larger sub array
        while (i < len1 && j < len2)
        {
            if (left[i].compareTo(right[j])<=0)
            {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        // of left, if any
        while (i < len1)
        {
            arr[k] = left[i];
            k++;
            i++;
        }

        // Copy remaining element
        // of right, if any
        while (j < len2)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    // Iterative Timsort function to sort the
    // array[0...n-1] (similar to merge sort)
    public static void timSort(Attraction[] arr, int n)
    {
        int minRun = minRunLength(MIN_MERGE);

        // Sort individual subarrays of size RUN
        for (int i = 0; i < n; i += minRun)
        {
            insertionSort(arr, i,
                Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        // Start merging from size
        // RUN (or 32). It will
        // merge to form size 64,
        // then 128, 256 and so on
        // ....
        for (int size = minRun; size < n; size = 2 * size)
        {

            // Pick starting point
            // of left sub array. We
            // are going to merge
            // arr[left..left+size-1]
            // and arr[left+size, left+2*size-1]
            // After every merge, we
            // increase left by 2*size
            for (int left = 0; left < n;
                left += 2 * size)
            {

                // Find ending point of left sub array
                // mid+1 is starting point of right sub
                // array
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1),
                    (n - 1));

                // Merge sub array arr[left.....mid] &
                // arr[mid+1....right]
                if(mid < right)
                    merge(arr, left, mid, right);
            }
        }
    }

}
