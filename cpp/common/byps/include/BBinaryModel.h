/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
/*
 * BBinaryModel.h
 *
 */

#ifndef BBINARYMODEL_H_
#define BBINARYMODEL_H_

#include "Byps.h"


namespace byps {

class BBinaryModel {
public:

	static BBinaryModel MEDIUM() {
		return BBinaryModel(4,4,4,8);
	}

	int32_t GetPointerSize() const { return m_nPointerSize; }
	int32_t GetTypeIdSize() const { return m_nTypeIdSize; }
	int32_t GetLengthSize() const { return m_nLengthSize; }
	int32_t GetPacking() const { return m_nPacking; }

	BLENGTH ComputeArraySize(int32_t sizeofElement, int32_t arrayLength) const {
		return sizeofElement * arrayLength;
	}

	BBinaryModel(const BBinaryModel& rhs) {
		m_nPointerSize = rhs.m_nPointerSize;
		m_nTypeIdSize = rhs.m_nTypeIdSize;
		m_nLengthSize = rhs.m_nLengthSize;
		m_nPacking = rhs.m_nPacking;
	}

	string getProtocolId() {
		return string("S");
	}

private:
	BBinaryModel(int32_t nPointerSize, int32_t nTypeIdSize, int32_t nLengthSize, int32_t nPacking)
	: m_nPointerSize(nPointerSize), m_nTypeIdSize(nTypeIdSize), m_nLengthSize(nLengthSize), m_nPacking(nPacking) {
	}

	int32_t m_nPointerSize;
	int32_t m_nTypeIdSize;
	int32_t m_nLengthSize;
	int32_t m_nPacking;
};

}


#endif /* BBINARYMODEL_H_ */
