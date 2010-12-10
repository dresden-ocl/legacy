/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp;

/**
 * The OclTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class OclTokenResolverFactory implements tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolverFactory {
	
	private java.util.Map<String, tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver> featureName2CollectInTokenResolver;
	private static tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver defaultResolver = new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclDefaultTokenResolver();
	
	public OclTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver>();
		registerTokenResolver("NAVIGATION_OPERATOR", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclNAVIGATION_OPERATORTokenResolver());
		registerTokenResolver("ADDITIVE_OPERATOR", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclADDITIVE_OPERATORTokenResolver());
		registerTokenResolver("MULT_OPERATOR", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclMULT_OPERATORTokenResolver());
		registerTokenResolver("RELATIONAL_OPERATOR", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclRELATIONAL_OPERATORTokenResolver());
		registerTokenResolver("EQUALITY_OPERATOR", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclEQUALITY_OPERATORTokenResolver());
		registerTokenResolver("NEQUALITY_OPERATOR", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclNEQUALITY_OPERATORTokenResolver());
		registerTokenResolver("NOT_OPERATOR", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclNOT_OPERATORTokenResolver());
		registerTokenResolver("AND_OPERATOR", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclAND_OPERATORTokenResolver());
		registerTokenResolver("OR_OPERATOR", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclOR_OPERATORTokenResolver());
		registerTokenResolver("XOR_OPERATOR", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclXOR_OPERATORTokenResolver());
		registerTokenResolver("IMPLIES_OPERATOR", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclIMPLIES_OPERATORTokenResolver());
		registerTokenResolver("IS_MARKED_PRE", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclIS_MARKED_PRETokenResolver());
		registerTokenResolver("BOOLEAN_LITERAL", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclBOOLEAN_LITERALTokenResolver());
		registerTokenResolver("COLLECTION_TYPES", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclCOLLECTION_TYPESTokenResolver());
		registerTokenResolver("ITERATOR_NAME", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclITERATOR_NAMETokenResolver());
		registerTokenResolver("STATIC", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclSTATICTokenResolver());
		registerTokenResolver("INTEGER_0", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclINTEGER_0TokenResolver());
		registerTokenResolver("INTEGER_LITERAL", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclINTEGER_LITERALTokenResolver());
		registerTokenResolver("SIMPLE_NAME", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclSIMPLE_NAMETokenResolver());
		registerTokenResolver("QUOTED_39_39", new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclQUOTED_39_39TokenResolver());
	}
	
	public tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver internalCreateResolver(java.util.Map<String, tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver> resolverMap, String key, tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
