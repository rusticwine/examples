package org.dolezel.bnpcardifcasestudy;


import lombok.Getter;

@Getter
public class PersistentResourceNotFoundException extends RuntimeException {

    private final String id;
    private final String type;


    /**
     * Create exception with info of id or search parameters and table which failed to return results
     *
     * @param errorMessage
     * @param searchCriteria - id of a resource
     * @param type           - entity/table
     */
    public PersistentResourceNotFoundException(String errorMessage, String searchCriteria, String type) {
        super(errorMessage);
        this.id = searchCriteria;
        this.type = type;
    }
}
