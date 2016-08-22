package app.dao.support;

import app.GenericDao.support.GenericDaoImpl;
import app.dao.LeafDao;
import app.domain.Leaf;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LeafDaoImpl extends GenericDaoImpl<Leaf, Long> implements LeafDao {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public Leaf getUnlabeledEntry() {
        List<Leaf> leaves = new ArrayList<Leaf>();
        leaves = this.findAll(new Leaf());
        for(Leaf l : leaves){
            if(l.getIsCompound() == null && !l.getType().toLowerCase().contains("photograph")) return l;

        }
        return null;
    }

    @Override
    public Leaf getNextEntry(Leaf leaf) {
        if(leaf != null) {
            Leaf l = this.find(new Leaf(), leaf.getId() + 1);
            if(l == null) return leaf;
            while(l.getType().toLowerCase().contains("photograph")){
                l = this.find(new Leaf(), l.getId() + 1);
                if(l == null) return leaf;
            }
            return l;
        }
        return null;
    }

    @Override
    public Leaf getPreviousEntry(Leaf leaf) {
        if(leaf != null) {
            Leaf l = this.find(new Leaf(), leaf.getId() - 1);
            if(l == null) return leaf;
            while(l.getType().toLowerCase().contains("photograph")){
                l = this.find(new Leaf(), l.getId() - 1);
                if(l == null) return leaf;
            }
            return l;
        }
        return null;
    }

    @Override
    public Leaf markAsCompound(Leaf leaf) {
        if(leaf != null){
            logger.info("Marking as compound : " + leaf.getId());
            leaf.setIsCompound(true);
            this.update(leaf);
            leaf = this.find(new Leaf(), leaf.getId());
            logger.info("DONE : LeafId " + leaf.getId() + ", isCompound? " + leaf.getIsCompound() );
            return leaf;
        }
        return null;
    }

    @Override
    public Leaf markAsSimple(Leaf leaf) {
        if(leaf != null){
            logger.info("Marking as simple : " + leaf.getId());
            leaf.setIsCompound(false);
            this.update(leaf);
            leaf = this.find(new Leaf(), leaf.getId());
            logger.info("DONE : LeafId " + leaf.getId() + ", isCompound? " + leaf.getIsCompound() );
            return leaf;
        }
        return null;
    }

    @Override
    public List getCompoundLeaves() {
        String where = "is_compound=:is_compound";
        Map<String, String> params = new HashMap<>();
        params.put("is_compound", "1");
        return this.findWhere(new Leaf(), where, params);
    }
}
